
public  class ConfigurationExporter {
    public String SQLText;
    public String longTextValue;

    public ConfigurationExporter() {
        SQLText = null;
        longTextValue = null;
    }

    public  void writeConfiguration() {
        StringBuilder configXMLString = new StringBuilder();
        configXMLString.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
configXMLString.append("<ConfigRoot xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" version=\"-1\" name=\"UNSAVED\" xsi:schemaLocation=\"\">");
configXMLString.append("Indices");
configXMLString.append("Index type=\"ruleXXX\"");
configXMLString.append("ConfigElement name=\"Execute onto a business document\"");
configXMLString.append("Attribute valueType=\"String-value\" value=\"\" label=\"Description\" id=\"description\"/");
configXMLString.append("Attribute valueType=\"boolean-value\" value=\"True\" label=\"Authenticate rule\" id=\"warnings\"/");
configXMLString.append("Index type=\"rule_factory\"");
configXMLString.append("ConfigElement name=\"C_Calculate_First_Party_Age_Group\"");
configXMLString.append("Attribute valueType=\"RLT\" value=\"");
configXMLString.append(this.getSQLText());
configXMLString.append("\" label=\"Rule template\" id=\"ruleFactory\"");
configXMLString.append("ValueObject name=\"C_Calculate_First_Party_Real_age\"/");
configXMLString.append("/Attribute");
configXMLString.append("Attribute valueType=\"boolean-value\" value=\"True\" label=\"Integrity check\" id=\"ruleWarnings\"/");
configXMLString.append("Attribute valueType=\"boolean-value\" value=\"True\" label=\"Export file to dir A\" id=\"builder\"/");
configXMLString.append("Attribute valueType=\"boolean-value\" value=\"False\" label=\"Export file to dir B\" id=\"fusion\"/");
configXMLString.append("Attribute valueType=\"boolean-value\" value=\"False\" label=\"Export file to dir C\" id=\"live\"/");
configXMLString.append("Attribute valueType=\"boolean-value\" value=\"False\" label=\"Export file to dir D\" id=\"visualization\"/");
configXMLString.append("Index type=\"special_case\"");
configXMLString.append("ConfigElement name=\"Default\"");
configXMLString.append("Attribute valueType=\"boolean-value\" value=\"True\" label=\"Apply this rule\" id=\"enabled\"/");
configXMLString.append("Attribute valueType=\"DefinitionElement\" value=\"Text: Calculate First Party Age\" label=\"FPDOB\" id=\"result.Output Variables.FPDOB\"/");
configXMLString.append("Attribute valueType=\"longText-value\" value=\"");
configXMLString.append(this.getLongTextValue());
configXMLString.append("\" label=\"First_Party_DOB\" id=\"scorer.Output Variables.VehicleAttribute\"/");
configXMLString.append("Attribute valueType=\"boolean-value\" value=\"False\" label=\"currentDate\" id=\"currentDate\"/");
configXMLString.append("Attribute valueType=\"boolean-value\" value=\"False\" label=\"dobDate\" id=\"dobDate\"/");
configXMLString.append("/ConfigElement");
configXMLString.append("/Index");
configXMLString.append("/ConfigElement");
configXMLString.append("/Index");
configXMLString.append("/ConfigElement");
configXMLString.append("/Index");
configXMLString.append("/Indices");
configXMLString.append("ConfigToolVersions");
configXMLString.append("ConfigToolVersion>8.625</ConfigToolVersion");
configXMLString.append("/ConfigToolVersions");
configXMLString.append("UIEditors");
configXMLString.append("UIEditor>com.myPackage.packageA</UIEditor");
configXMLString.append("UIEditor>com.myPackage.packageB</UIEditor");
configXMLString.append("UIEditor>com.myPackage.packageC</UIEditor");
configXMLString.append("UIEditor>com.myPackage.packageD</UIEditor");
configXMLString.append("UIEditor>com.myPackage.packageE</UIEditor");
configXMLString.append("UIEditor>com.myPackage.packageF</UIEditor");
configXMLString.append("UIEditor>com.myPackage.packageG</UIEditor");
configXMLString.append("/UIEditors");
configXMLString.append("Dependencies");
configXMLString.append("Dependency>../../Templates/myTemplates.xml</Dependency");
configXMLString.append("Dependency>../../Definitions/myDefinition.xml</Dependency");
configXMLString.append("/Dependencies");
configXMLString.append("/ConfigRoot>");
        System.out.println(configXMLString.toString());
    }

    public  String getSQLText() {
        return this.SQLText;
    }
    public  void setSQLText(String text) {
        this.SQLText = text;
    }
    public  String getLongTextValue() {
        return this.longTextValue;
    }
    public  void setLongTextValue(String text) {
        this.longTextValue = text;
    }

    public static void main(String[] args) {
        ConfigurationExporter configurationExporter = new ConfigurationExporter();
        configurationExporter.setLongTextValue("longlong");
        configurationExporter.setSQLText("sqlsql");
        configurationExporter.writeConfiguration();
    }
}
