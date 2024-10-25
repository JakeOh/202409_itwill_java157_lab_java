package com.itwill.blog.view;

import java.util.Scanner;

//import com.itwill.blog.controller.BlogController;
import com.itwill.blog.controller.BlogDao;
import com.itwill.blog.controller.BlogDaoImpl;

// MVC 아키텍쳐에서 View(UI, 입/출력)를 담당하는 클래스.
public class BlogMain {
    
    private Scanner scanner = new Scanner(System.in);
    private BlogDao dao = BlogDaoImpl.getInstance(); // 다형성. singleton.
//    private BlogController controller = BlogController.INSTANCE;
    
    public static void main(String[] args) {
        System.out.println("*** 블로그 앱 ***");
        
        BlogMain app = new BlogMain(); // BlogMain 클래스의 static이 아닌 멤버들을 사용하기 위해서.
        
        boolean run = true;
        while (run) {
            MainMenu menu = app.selectMainMenu();
            switch (menu) {
            case QUIT: // 종료
                run = false;
                break;
            case CREATE: // 새글작성
                app.createNewBlog();
                break;
            case READ_ALL: // 목록보기
                // TODO
                break;
            case READ_BY_INDEX: // 상세보기
                // TODO
                break;
            case UPDATE: // 업데이트
                // TODO
                break;
            default: // case UNKNOWN:
                System.out.println(">>> 메뉴(0 ~ 4)를 다시 선택하세요...");
            }
            
        }

        System.out.println("*** 블로그 앱 종료 ***");
    }

    private void createNewBlog() {
        // TODO
        dao.create(null);
    }
    
    private MainMenu selectMainMenu() {
        System.out.println("\n----------------------------------------------------------");
        System.out.println("0.종료 | 1.새글작성 | 2.목록보기 | 3.상세보기 | 4.업데이트");
        System.out.println("----------------------------------------------------------");
        System.out.print("선택> ");
        int choice = Integer.parseInt(scanner.nextLine());
        
        return MainMenu.getMainMenu(choice);
    }

}
