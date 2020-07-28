package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Employee;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor.
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String context_path = ((HttpServletRequest) request).getContextPath();
        String servlet_path = ((HttpServletRequest) request).getServletPath();
        //cssフォルダは認証処理から除外する
        if (!servlet_path.matches("/css.*")) {
            HttpSession session = ((HttpServletRequest) request).getSession();

            Employee e = (Employee) session.getAttribute("login_employee");
            if (!servlet_path.matches("/login.*")) {//ログイン画面以外の場合
                //ログアウトしている状態ならば、ログイン画面にリダイレクト
                if (e == null) {
                    ((HttpServletResponse) response).sendRedirect(context_path + "/login");
                    return;
                }

                //管理者のみ、従業員管理ページを閲覧できる。一般(Admin_flag=0)は閲覧できない。
                if (servlet_path.matches("/employees.*") && e.getAdmin_flag() == 0) {
                    ((HttpServletResponse) response).sendRedirect(context_path + "/");
                }
            } else {//ログイン画面の場合
                if (e != null) {
                    //ログインしているのにログインページに飛ぼうとしたら、トップページにリダイレクト
                    ((HttpServletResponse) response).sendRedirect(context_path + "/");
                    return;
                }
            }
        }

        // pass the request along the filter chain
        chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}
