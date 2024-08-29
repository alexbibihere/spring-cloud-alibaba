import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SqlCodeInfo {
    private String projectPath = System.getProperty("user.dir");
    private String parentPackage;
    private String author = "auto";
    private String dbIp;
    private Integer dbPort;
    private String dbBase;
    private String dbUser;
    private String dbPwd;
    private String moduleName;
    private String tables;
    private Boolean fileOverride;


    public Boolean getFileOverride() {
        return fileOverride;
    }

    public void setFileOverride(Boolean fileOverride) {
        this.fileOverride = fileOverride;
    }




    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public String getParentPackage() {
        return parentPackage;
    }

    public void setParentPackage(String parentPackage) {
        this.parentPackage = parentPackage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDbIp() {
        return dbIp;
    }

    public void setDbIp(String dbIp) {
        this.dbIp = dbIp;
    }

    public Integer getDbPort() {
        return dbPort;
    }

    public void setDbPort(Integer dbPort) {
        this.dbPort = dbPort;
    }

    public String getDbBase() {
        return dbBase;
    }

    public void setDbBase(String dbBase) {
        this.dbBase = dbBase;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPwd() {
        return dbPwd;
    }

    public void setDbPwd(String dbPwd) {
        this.dbPwd = dbPwd;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getTables() {
        return tables;
    }

    public void setTables(String tables) {
        this.tables = tables;
    }
}