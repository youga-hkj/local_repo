package com.project.test;

import java.io.File;



import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

import com.project.commons.LuceneIndexUtil;
import com.project.po.Goods;

public class LucenTest {
	LuceneIndexUtil indexutil = new LuceneIndexUtil();
	
	@Test
	public void testAddIndex(){
		Goods good = new Goods();
		good.setGid(12345);
		good.setGname("IBM笔记本电脑");
		good.setGprice(34.56);
		good.setRemark("IBM笔记本电脑, 小黑 永恒的经典....");
		indexutil.addIndex(good);
		System.out.println("insert data success!");
	}
	@Test
	public void testSearchIndex(){
		String x = "电脑";
		IndexSearcher indexsearcher = null;
		Analyzer analyzer = null;
		Directory dir = null;
		
		try {
//			指定索引库位置
			dir = FSDirectory.open(new File("./indexData"));
//			查询suoyin
			indexsearcher = new IndexSearcher(dir);
//			创建一个分词器
			analyzer = new StandardAnalyzer(Version.LUCENE_30);
//			创建一个jiexiqi                                                    版本                     查询字段  分词器
			QueryParser queryparser = new QueryParser(Version.LUCENE_30, "gname", analyzer);
//			类似hibernate中的query
			Query query = queryparser.parse(x);
//			返回查询结果
			TopDocs topdocs = indexsearcher.search(query, 10);
			System.out.println("搜索结果共："+topdocs.totalHits);
			for(int i = 0 ;i<topdocs.totalHits; i++){
				ScoreDoc socredoc = topdocs.scoreDocs[i];
				System.out.println("当前数据在索引库中编号 :"+socredoc.doc);
				Document doc = indexsearcher.doc(socredoc.doc);
				Goods goods = new Goods();
				goods.setGid(Integer.parseInt(doc.get("gid")));
				goods.setGname(doc.get("gname"));
				goods.setGprice(Double.parseDouble(doc.get("gprice")));
				goods.setRemark(doc.get("gremark"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
