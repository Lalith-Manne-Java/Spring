import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
public class AddingDocument {
    public static void main(String args[]) throws Exception {
        //Preparing solr client
        String urlString = "http://localhost:8984/solr/techproducts";
        SolrClient solr = new HttpSolrClient.Builder(urlString).build();

        //Preparing solr document
        SolrInputDocument docu = new SolrInputDocument();

        //Adding fields to the documents
        docu.addField("id", "0923");
        //docu.addField("name", "lalli");

        //Adding collection data to the solr
        Map<String, String> lal = new HashMap<String, String>();
        //.lal.put("id", "98");
        lal.put("name", "mamaj144");

        lal.forEach((k, v) -> docu.addField(k,v));

        //Adding Document to solr
        solr.add(docu);

        //Saving the changes
        solr.commit();
        System.out.println("Documents added");
    }

}
