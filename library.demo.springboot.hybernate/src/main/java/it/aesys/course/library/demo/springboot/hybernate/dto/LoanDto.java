package it.aesys.course.library.demo.springboot.hybernate.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class LoanDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date creationDate;
    private String titleId;
    private String taxCode;

    public LoanDto() {
    }

    public LoanDto(String titleId, String taxCode, Date creationDate) {
        this.creationDate = creationDate;
        this.titleId = titleId;
        this.taxCode = taxCode;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }
}
