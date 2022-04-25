package org.library.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Scope("singleton")
public class Storage {
  @JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
  private Date creationDate;
  private List<StorageProperty> storagePropertyList = new ArrayList<>();

  public void addStorageProperty(int titleid, int userLibraryId) {
    StorageProperty storageProperty = new StorageProperty(titleid, userLibraryId);
    storagePropertyList.add(storageProperty);
  }

  public Storage() {
    this.creationDate = new Date();
  }

  public Storage(Date creationDate, int titleId) {
    this.creationDate = creationDate;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    if (creationDate != null)
      this.creationDate = creationDate;
  }
}
