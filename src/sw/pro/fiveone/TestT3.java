package sw.pro.fiveone;

import java.sql.Connection;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class TestT3 {

	public static void main(String[] args) throws Exception {
		Properties pro = new Properties();
		pro.setProperty(Context.PROVIDER_URL, "t3://localhost:7001");
		pro.setProperty(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.T3InitialContextFactory");
		Context ctx = new InitialContext(pro);
		DataSource ds = (DataSource) ctx.lookup("datasource-1");
		Connection cn = ds.getConnection();
		System.out.println(cn);

	}

}
