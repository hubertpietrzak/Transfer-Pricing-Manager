package pl.coderslab.documentation;

import pl.coderslab.company.Company;


public interface DocumentationAggregate {

    public long getId();

    public Company getCompany();

    public long getContractorsId();

    public String getTypeOfTransaction();

    public String getDescription();

    public int getNetValue();

    public int getPaidValue();

    public String getYear();

    public String getStatusOfDocumentation();

}
