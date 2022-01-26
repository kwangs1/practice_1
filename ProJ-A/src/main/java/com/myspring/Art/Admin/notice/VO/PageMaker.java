package com.myspring.Art.Admin.notice.VO;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {//페이징 버튼들을 만들기 위한 계산클래스

	private Criteria cri;
	private int totalCount; //총 게시글 수
	private int startPage; //화면에 보여질 첫번째 페이지 번호, 시작 페이지 번호
	private int endPage; //화면에 보여질 마지막 페이지 번호, 끝 페이지 번호
	private boolean prev; //이전 버튼 생성 여부
	private boolean next; //다음 버튼 생성 여부
	private int displayPageNum = 5; //화면에 보여지는 페이지 버튼의 수
	
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}
	
	private void calcData() {
		
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
        int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
        if (endPage > tempEndPage) {
            endPage = tempEndPage;
        }
        
        startPage = (endPage - displayPageNum) + 1;
        if(startPage < 0) startPage=1;
 
        prev = startPage == 1 ? false : true;
        next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
        
	}
	
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	
	public String makeQuery(int page) {
		UriComponents uriComponents =
		UriComponentsBuilder.newInstance()
						    .queryParam("page", page)
							.queryParam("perPageNum", cri.getPerPageNum())
							.build();
		   
		return uriComponents.toUriString();
	}
}
