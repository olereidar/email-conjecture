package checkMXReccord;

import javax.naming.NamingException;
import javax.naming.directory.*;
import java.util.Hashtable;

public class ValidateExsistingMailServer {

    public int doLookup(String hostName) throws NamingException {
        Hashtable env = new Hashtable();
        env.put("java.naming.factory.initial",
                "com.sun.jndi.dns.DnsContextFactory");
        DirContext ictx = new InitialDirContext(env);
        Attributes attrs =
                ictx.getAttributes(hostName, new String[]{"MX"});
        Attribute attr = attrs.get("MX");
        if (attr == null) return (0);
        return (attr.size());
    }

}
