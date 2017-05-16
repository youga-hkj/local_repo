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
		good.setGname("IBM�ʼǱ�����");
		good.setGprice(34.56);
		good.setRemark("IBM�ʼǱ�����, С�� ����ľ���....");
		indexutil.addIndex(good);
		System.out.println("insert data success!");
	}
	@Test
	public void testSearchIndex(){
		String x = "����";
		IndexSearcher indexsearcher = null;
		Analyzer analyzer = null;
		Directory dir = null;
		
		try {
//			ָ��������λ��
			dir = FSDirectory.open(new File("./indexData"));
//			��ѯsuoyin
			indexsearcher = new IndexSearcher(dir);
//			����һ���ִ���
			analyzer = new StandardAnalyzer(Version.LUCENE_30);
//			����һ��jiexiqi                                                    �汾                     ��ѯ�ֶ�  �ִ���
			QueryParser queryparser = new QueryParser(Version.LUCENE_30, "gname", analyzer);
//			����hibernate�е�query
			Query query = queryparser.parse(x);
//			���ز�ѯ���
			TopDocs topdocs = indexsearcher.search(query, 10);
			System.out.println("�����������"+topdocs.totalHits);
			for(int i = 0 ;i<topdocs.totalHits; i++){
				ScoreDoc socredoc = topdocs.scoreDocs[i];
				System.out.println("��ǰ�������������б�� :"+socredoc.doc);
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
