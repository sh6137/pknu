package com.spring.pds.service.impl;

import com.spring.pds.vo.PdsVo;

public class BoardPaging {
		private int recordCount;
	   private int nowPage;
	   private int prevNowPage;
	   private int nextNowPage;
	   private int pageCount;
	   
	   private int pageTotalCount;
	   private int pagegrpNum;
	   
	   private int startPageNum;
	   private int endPageNum;
	   
	   private int totalRecordPageCount;
	   
	   private boolean isshowPagePrev;
	   private boolean isshowPageNext;
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getPrevNowPage() {
		return prevNowPage;
	}
	public void setPrevNowPage(int prevNowPage) {
		this.prevNowPage = prevNowPage;
	}
	public int getNextNowPage() {
		return nextNowPage;
	}
	public void setNextNowPage(int nextNowpage) {
		this.nextNowPage = nextNowpage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageTotalCount() {
		return pageTotalCount;
	}
	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
	public int getPagegrpNum() {
		return pagegrpNum;
	}
	public void setPagegrpNum(int pagegrpNum) {
		this.pagegrpNum = pagegrpNum;
	}
	public int getStartPageNum() {
		return startPageNum;
	}
	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}
	public int getEndPageNum() {
		return endPageNum;
	}
	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}
	public int getTotalRecordPageCount() {
		return totalRecordPageCount;
	}
	public void setTotalRecordPageCount(int totalRecordPageCount) {
		this.totalRecordPageCount = totalRecordPageCount;
	}
	public boolean isIsshowPagePrev() {
		return isshowPagePrev;
	}
	public void setIsshowPagePrev(boolean isshowPagePrev) {
		this.isshowPagePrev = isshowPagePrev;
	}
	public boolean isIsshowPageNext() {
		return isshowPageNext;
	}
	public void setIsshowPageNext(boolean isshowPageNext) {
		this.isshowPageNext = isshowPageNext;
	}
	public BoardPaging(int nowPage, int pageCount, int recordCount, int pageTotalCount, int pagegrpNum) {
		super();
		this.recordCount = recordCount;
		this.nowPage = nowPage;
		this.pageCount = pageCount;
		this.pageTotalCount = pageTotalCount;
		this.pagegrpNum = pagegrpNum;
		
	}
	public BoardPaging() {
		
	}
	   public PdsVo getPdsPagingInfo() {
		      PdsVo   vo = new PdsVo();
		      this.totalRecordPageCount = 
		            (int) Math.ceil( (double) recordCount / (double) pageCount );
		      
		      this.startPageNum =  (pagegrpNum - 1) * pageTotalCount + 1;
		      this.endPageNum = 
		          totalRecordPageCount < (pagegrpNum * pageTotalCount) ?
		            totalRecordPageCount : (pagegrpNum * pageTotalCount);   
		            
		      if(startPageNum == 1 ) isshowPagePrev = false;
		      if(endPageNum >= totalRecordPageCount ) isshowPageNext = false;
		      
		      this.prevNowPage  = startPageNum - 1;  // ◀ [이전 10개]
		      this.nextNowPage = endPageNum   + 1;  // ▶ [다음 10개] 
		            
		      vo.setNowpage(this.nowPage);
		      vo.setPrevnowpage(this.prevNowPage);
		      vo.setNextnowpage(this.nextNowPage);
		      
		      vo.setRecordcount(this.recordCount);
		      vo.setTotalPagecount(this.pageTotalCount);
		      
		      vo.setPagestartnum(this.startPageNum);
		      vo.setPageendnum(this.endPageNum);
		      
		      vo.setPagecount(this.pageCount);
		      vo.setPagegrpnum(this.pagegrpNum);
		      
		      vo.setIsshowpagenext(isshowPageNext);
		      vo.setIsshowpageprev(isshowPagePrev);      
		      
		      return vo;   
		      
		      
		   }
	   
	      
}
