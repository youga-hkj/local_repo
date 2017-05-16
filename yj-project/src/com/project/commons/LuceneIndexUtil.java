package com.project.commons;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriter.MaxFieldLength;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import com.project.po.Goods;

public class LuceneIndexUtil {
	//add index 
	public void addIndex(Goods good) {
		IndexWriter indexwriter = null;
		Directory dir = null;
		Analyzer analyzer = null;
		try {
			// create a simple analyzer
			analyzer = new StandardAnalyzer(Version.LUCENE_30);
			// creat a fs directory instance
			dir = FSDirectory.open(new File("./indexData"));
			// create util to insert update delete index
			indexwriter = new IndexWriter(dir, analyzer, MaxFieldLength.LIMITED);
			Document doc = new Document();
			doc.add(new Field("gid", good.getGid().toString(), Store.YES,
					Index.NOT_ANALYZED));
			doc.add(new Field("gname", good.getGname(), Store.YES,
					Index.ANALYZED));
			doc.add(new Field("gprice", good.getGprice().toString(),
					Store.YES, Index.NOT_ANALYZED));
			doc.add(new Field("gremark", good.getRemark(), Store.YES, Index.NO));
			indexwriter.addDocument(doc);
			indexwriter.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				indexwriter.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * search index
	 * @param qname
	 * @return
	 */
	public List<Goods> queryIndex(String qname){
		List<Goods> goodlist = new ArrayList<Goods>();
		Directory dir = null;
		IndexSearcher indexsearch = null;
		Analyzer analyzer = null;
		
		try{
			dir = FSDirectory.open(new File("./indexData"));
			indexsearch = new IndexSearcher(dir);
			analyzer = new StandardAnalyzer(Version.LUCENE_30);
			QueryParser queryparse = new QueryParser(Version.LUCENE_30, "gname", analyzer);
			Query query = queryparse.parse(qname);
			TopDocs topdoc = indexsearch.search(query, 10);
			System.out.println("当前搜索结果数为："+topdoc.totalHits);
			for(int i = 0;i<topdoc.totalHits;i++){
				ScoreDoc scoredoc = topdoc.scoreDocs[i];
				System.out.println("当前doc在索引库中的编号为："+scoredoc.doc);
				Document doc = indexsearch.doc(scoredoc.doc);
				Goods goods = new Goods();
				goods.setGid(Integer.parseInt(doc.get("gid")));
				goods.setGname(doc.get("gname"));
				goods.setGprice(Double.parseDouble(doc.get("gprice")));
				goods.setRemark(doc.get("gremark"));
				goodlist.add(goods);

			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				indexsearch.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return goodlist;
	}

}
