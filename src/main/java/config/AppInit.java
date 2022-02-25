package config;


import org.jetbrains.annotations.NotNull;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {Hibernate.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {WebConfig.class};
    }

    @Override
    protected String @NotNull [] getServletMappings() {
        return new String[] {"/"};
    }
    @Override
    public void onStartup(ServletContext ServletContext) throws ServletException {
        super.onStartup(ServletContext);
        registerHiddenFieldFilter(ServletContext);
    }

    private void registerHiddenFieldFilter(ServletContext Context) {
        Context.addFilter("hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null ,true, "/*");
    }
}