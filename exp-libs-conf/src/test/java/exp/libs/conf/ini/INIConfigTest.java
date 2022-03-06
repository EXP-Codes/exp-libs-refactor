package exp.libs.conf.ini;

import exp.libs.utils.str.StrUtils;

class INIConfigTest {

    public static void main(String[] args) {
        String moduleName = "exp-libs-conf";

        // 读取jar包内的ini配置文件
        INIConfig iniJar = new INIConfig("/global.properties");
        System.out.println(iniJar.getAllKVs());

        // 读取磁盘的ini配置文件
        INIConfig iniFile = new INIConfig(
                StrUtils.concat("./", moduleName, "/conf/global.properties")
        );
        System.out.println(iniFile.getAllKVs());
        iniFile.save();
    }

}