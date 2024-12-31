package StudentTeacherRecordSystem;

public class TestStudentTeacherRecordSystem {
    public static void main(String[] args) {
        IDandPasswords iDandPasswords = new IDandPasswords();
        LoginPage loginPage = new LoginPage(iDandPasswords.getLoginInfo());
    }
}
