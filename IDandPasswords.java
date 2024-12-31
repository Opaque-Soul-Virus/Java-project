package StudentTeacherRecordSystem;

import java.util.HashMap;

public class IDandPasswords {
    HashMap<String,String> loginInfo = new HashMap<String,String>();

    public IDandPasswords() {
        loginInfo.put("Sifat Zaman","abc123*e#");
        loginInfo.put("OpaqueSoulVirus","ABC1232024");
        loginInfo.put("username","password");
    }

    public HashMap getLoginInfo(){
        return loginInfo;
    }
}
