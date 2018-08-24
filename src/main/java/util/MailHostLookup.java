package util;

import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;

public class MailHostLookup {

    public static boolean lookupMailHostDomain(String domainName) {
        try {
            new InitialDirContext().getAttributes("dns:/" + domainName, new String[]{"MX"});
        } catch (NamingException e) {
            return false;
        }
        return true;
    }

}
