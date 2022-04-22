package it.aesys.infopeople.infopeople.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.aesys.infopeople.infopeople.model.Persons;
import it.aesys.infopeople.infopeople.repository.exceptions.DaoException;
import it.aesys.infopeople.infopeople.repository.exceptions.EmptyFileSystemRepositoryExcepton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.thymeleaf.util.StringUtils;

import java.io.*;
import java.util.Collection;
import java.util.List;


public class FileSystemRepository<P> {

    @Autowired
    private ObjectMapper mapper ;

    @Value("${repository.filesystem.basepath}")
    private String basepath;


    public FileSystemRepository() {
        mapper = new ObjectMapper();
    }

    public ObjectMapper getMapper() {
        return mapper;
    }

    public void setMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public void serializeCollection(P p,String filename) {
        PrintWriter printWriter = null;
        try {
            if (basepath==null) basepath = "C:/LAVORO";
            String value = mapper.writeValueAsString(p);

            File file = new File(basepath +"/"+ filename );
            FileWriter fileWriter = null;

            fileWriter = new FileWriter(file);
            printWriter = new PrintWriter(fileWriter);
            printWriter.print(value);
            printWriter.close();


        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (printWriter!=null) {
                printWriter.close();
            }
        }

    }

    public P unserialize(String filename, Class<P> clazz) throws EmptyFileSystemRepositoryExcepton {
        PrintWriter printWriter = null;
        if (basepath==null) basepath = "C:/LAVORO";
        try {
            File file = new File(basepath +"/"+ filename );
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String currentLine = reader.readLine();
            reader.close();
            if (StringUtils.isEmpty(currentLine)) {
                throw  new EmptyFileSystemRepositoryExcepton();
            }
            return  mapper.readValue(currentLine,   clazz);
        } catch (JsonProcessingException e) {
            return null;
        } catch (IOException e) {
           return null;
        }finally{
            if (printWriter!=null) {
                printWriter.close();
            }
        }

    }


}
