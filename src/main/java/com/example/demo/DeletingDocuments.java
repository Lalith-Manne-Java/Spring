package com.example.demo;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;

public class DeletingDocuments {
    public static void main(String args[]) throws IOException, SolrServerException {
        String urlString = "http://localhost:8984/solr/techproducts";
        SolrClient solrDelete = new HttpSolrClient.Builder(urlString).build();
        //Preparing solr document
        SolrInputDocument solrDoc = new SolrInputDocument();
        //Delete Document
        solrDelete.deleteById("0923");
        //Saving the updates
        solrDelete.commit();
        System.out.println("Deleted the documents");
    }
}
