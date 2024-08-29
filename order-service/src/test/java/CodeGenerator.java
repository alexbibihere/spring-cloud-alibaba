import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {
    public void generatorCode(SqlCodeInfo sqlCodeInfo) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = sqlCodeInfo.getProjectPath();
        gc.setOutputDir(projectPath + "src/main/java");
        gc.setAuthor(sqlCodeInfo.getAuthor());
        gc.setFileOverride(sqlCodeInfo.getFileOverride());
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(true);
        gc.setOpen(false);
        gc.setEntityName("%sEntity");
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(String.format("jdbc:mysql://%s:%d/%s?serverTimezone=UTC&useUnicode=true&useSSL=false&characterEncoding=utf8",
                sqlCodeInfo.getDbIp(), sqlCodeInfo.getDbPort(), sqlCodeInfo.getDbBase()));
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(sqlCodeInfo.getDbUser());
        dsc.setPassword(sqlCodeInfo.getDbPwd());
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(sqlCodeInfo.getModuleName());
        pc.setParent(sqlCodeInfo.getParentPackage());
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setCapitalMode(true);
        // 公共父类
//        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id");
        strategy.setInclude(sqlCodeInfo.getTables().split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new VelocityTemplateEngine());
        mpg.execute();
    }

    public static void main(String[] args) {

        //数据库ip
//        new CodeGenerator().generatorCode(new SqlCodeInfo()
//                .setDbIp("127.0.0.1")//数据库库名
//                .setDbPort(3306)//端口
//                .setDbUser("xxx")//用户
//                .setDbPwd("xxx")//密码
//                .setFileOverride(true)
//                .setModuleName("")//模块名
//                .setParentPackage("com.fs.springcloud")//包名
//                .setTables("user")//数据库建好的表名
//                .setProjectPath(System.getProperty("user.dir") + "/springcloud-mybatisPlus-example" + File.separator));//项目名称
    }
}