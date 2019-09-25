package myDispatcher;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	
	private Map<String,Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String,Controller>() ;
		mappings.put("/mlist.do", new ListController());
		mappings.put("/login.do", new LoginController());
		mappings.put("/mdetail.do", new DetailController());
		mappings.put("/mjoin.do", new JoinController());
		mappings.put("/mupdate.do", new UpdateController());
		mappings.put("/mdelete.do", new DeleteController());
	}
	
	public Controller getController(String path) {
		return mappings.get(path) ;
	}
}
