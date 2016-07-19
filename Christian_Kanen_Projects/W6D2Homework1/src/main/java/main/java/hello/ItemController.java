package main.java.hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.EntityManager;
import javax.swing.plaf.synth.SynthSplitPaneUI;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
public class ItemController {

	@RequestMapping("/getItemById/GET/item/{id}")
	public Items item(@PathVariable("id") String itemId) {

		ItemService itemService = new ItemService();
		itemService.init();
		EntityManager em = itemService.getEntityManager();
		
		
		/*List<Items> itemResult = itemService.getItemList(itemId);
		
		for (Items r : itemResult){
			if (itemId.equals(r.getItemId())){
				System.out.println(r.getItemId());
				System.out.println(r.getItemName());
				System.out.println(r.getItemCategory());
				System.out.println(r.getItemStock());
				System.out.println(r.getItemPrice());	
			}
			
		}
	*/
		return itemService.getItemId(em, itemId);
	}
	

}
