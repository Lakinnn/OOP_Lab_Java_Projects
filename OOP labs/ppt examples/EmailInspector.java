public class EmailInspector {
    public static void main(String[] args) {
        String email = "student@aastu.edu";
 
        int at = email.indexOf('@');
        String user = email.substring(0, at);
        String domain = email.substring(at + 1);
 
        System.out.println("User: " + user);
        System.out.println("Domain: " + domain);
        System.out.println("First: " + email.charAt(0));
        System.out.println("Is .edu? "
                + email.endsWith(".edu"));
    }
}