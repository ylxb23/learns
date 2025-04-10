package junit4s.regexp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UpCaseNaming {

    private static final Pattern P3C_CLASS_NAMING_UP_CASE_NAMING = Pattern.compile("^I?([A-Z][a-z0-9]+)(([A-Z])|(DO|DTO|VO|DAO|BO|DAOImpl|YunOS|AO|PO))?$");
    private static final Pattern P3C_CLASS_NAMING_UP_CASE_NAMING_EX = Pattern.compile("^I?([A-Z][a-z0-9]*)(([A-Z])|(DO|DTO|VO|DAO|BO|DAOImpl|YunOS|AO|PO))?\\w*$");
    private static final Pattern P3C_CLASS_NAMING_UP_CASE_NAMING_EXT = Pattern.compile("^I?([A-Z][a-z0-9]*)(([A-Z])|(DO|DTO|VO|DAO|BO|DAOImpl|YunOS|AO|PO|DOResource|DORepository|DORepositoryImpl))?$");

    private static final Pattern P3C_FIELD_NAMING_LOWER_CASE_NAMING = Pattern.compile("^[a-z][a-z0-9]([A-Z][a-z0-9]+)*(DO|DTO|VO|DAO|BO|DOList|DTOList|VOList|DAOList|BOList|X|Y|Z|UDF|UDAF|[A-Z])?$");
    private static final Pattern P3C_FIELD_NAMING_LOWER_CASE_NAMING_EXT = Pattern.compile("^[a-z][a-z0-9](([A-Z][a-z0-9]+)*(DO|DTO|VO|DAO|BO|DOList|DTOList|VOList|DAOList|BOList|X|Y|Z|UDF|UDAF|[A-Z])?)*$");

    public static void main(String[] args) {
        testMatchClazzNaming(P3C_CLASS_NAMING_UP_CASE_NAMING_EXT);
        testMatchPropertiesNaming(P3C_FIELD_NAMING_LOWER_CASE_NAMING_EXT);

//        replacePatternWithEmpty(P3C_FIELD_NAMING_LOWER_CASE_NAMING);
    }

    private static final Pattern ALLOWS_DOUBLE_UP_CASE_PATTERN = Pattern.compile("(DO|DTO|VO|PO|AO|BO|DAO)");

    private static void replacePatternWithEmpty(Pattern pattern) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> " + pattern.pattern() + "......");
        List<String> namings = new ArrayList<>();
        namings.add("getAllDOList");
        namings.add("getAllDOs");
        namings.add("getAllPO");
        namings.add("getAllPOList");
        namings.add("transferManDTO2VO");
        namings.add("transferManDTOList2VOList");
        for(String naming : namings) {
            String nn = naming;
            if(pattern.matcher(naming).matches()) {
                nn = naming.replaceFirst(ALLOWS_DOUBLE_UP_CASE_PATTERN.pattern(), "");
            }
            System.out.printf("new naming of %s is %s \n", naming, nn);
        }
    }


    public static void testMatchClazzNaming(Pattern pattern) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> " + pattern.pattern() + "......");
        List<String> namings = new ArrayList<>();
        namings.add("ManDO");
        namings.add("ManDTO");
        namings.add("ManPO");
        namings.add("ManPORepository");
        namings.add("ManPORepositoryImpl");
        namings.add("ManVO");
        namings.add("manVO");
        namings.add("manDO");
        namings.add("manDTO");

        for(String naming : namings) {
            if(pattern.matcher(naming).matches()) {
                System.out.printf("%s matched \n", naming);
            } else {
                System.out.printf("%s not match \n", naming);
            }
        }
    }

    public static void testMatchPropertiesNaming(Pattern pattern) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> " + pattern.pattern() + "......");
        List<String> namings = new ArrayList<>();
        namings.add("getManDOList");
        namings.add("getManDO");
        namings.add("getManVO");
        namings.add("getManVOList");
        namings.add("SetManDTO");
        namings.add("3asDO");
        namings.add("transferDO2DTO");

        for(String naming : namings) {
            if(pattern.matcher(naming).matches()) {
                System.out.printf("%s matched \n", naming);
            } else {
                System.out.printf("%s not match \n", naming);
            }
        }
    }
}
