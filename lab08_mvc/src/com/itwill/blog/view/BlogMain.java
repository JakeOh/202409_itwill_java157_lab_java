package com.itwill.blog.view;

import java.util.Scanner;

//import com.itwill.blog.controller.BlogController;
import com.itwill.blog.controller.BlogDao;
import com.itwill.blog.controller.BlogDaoImpl;
import com.itwill.blog.model.Blog;

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
                app.readAllBlogs();
                break;
            case READ_BY_INDEX: // 상세보기
                app.readBlogByIndex();
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

    private void readBlogByIndex() {
        System.out.println("\n--- 블로그 상세 보기 ---");
        
        // 검색할 블로그의 인덱스를 입력받음:
        System.out.print("인덱스> ");
        int index = Integer.parseInt(scanner.nextLine());
        
        // 컨트롤러의 메서드를 호출해서 입력받은 인덱스의 블로그를 읽어옴.
        Blog blog = dao.read(index);
        System.out.println(blog);
    }

    private void readAllBlogs() {
        System.out.println("\n--- 블로그 목록 ---");

        // 컨트롤러 메서드를 호출해서 블로그 배열을 가져옴.
        Blog[] blogs = dao.read();
        
        // 블로그 배열의 인덱스와 제목만 출력
        for (int i = 0; i < blogs.length; i++) {
            System.out.printf("[%d] %s\n", i, blogs[i].getTitle());
        }
    }

    private void createNewBlog() {
        System.out.println("\n--- 새 블로그 작성 ---");
        
        // 1. 새 블로그 작성에 필요한 제목/내용/작성자를 입력:
        System.out.print("제목> ");
        String title = scanner.nextLine();
        
        System.out.print("내용> ");
        String content = scanner.nextLine();
        
        System.out.print("작성자> ");
        String author = scanner.nextLine();
        
        // 2. Blog 타입 객체 생성:
        Blog blog = new Blog(title, content, author); 
        
        // 3. MVC 아키텍쳐에서 Controller의 메서드를 호출해서 블로그 작성(저장) 기능을 수행.
        int result = dao.create(blog);
        if (result == 1) {
            System.out.println(">> 새 블로그 작성 성공");
        } else {
            System.out.println(">> 새 블로그 작성 실패");
        }
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
