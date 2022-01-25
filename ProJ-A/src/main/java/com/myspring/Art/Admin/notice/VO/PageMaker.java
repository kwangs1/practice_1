package com.myspring.Art.Admin.notice.VO;

public class PageMaker {//페이징 버튼들을 만들기 위한 계산클래스

	private Criteria cri;
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int displayPageNum = 5;
	
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
	
	private void calcData() { //페이징 관련 버튼 계산 메서드
        
		//(현제페이지번호 / 화면에 보여질 페이지 번호갯수) * 화면에 보여질 페이지 번호 갯수
        endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum); 
        //마지막 페이지 번호 = 총게시글 수 / 한 페이지당 보여줄 게시글 갯수
        int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
        if (endPage > tempEndPage) {
            endPage = tempEndPage;
        }
        startPage = (endPage - displayPageNum) + 1; // 시작페이지 번호 = (끝 페이지번호 - 화면에 보여질 페이지 번호) +1
        if(startPage < 0) startPage = 1;
 
        prev = startPage == 1 ? false : true; // 이전 버튼은 시작페이지 번호가 1이 아니면 생성
        next = endPage * cri.getPerPageNum() < totalCount ? true : false;
        // 다음 버튼 생성 여부 = 끝 페이지 번호 * 한 페이지당 보여줄 게시글의 갯수 < 총 게시글의 수? true:false
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
	
	
}
