package org.srs.pipeline.web.taglib.upload;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import org.srs.datahandling.common.util.exception.BriefWriter;
/**
 * A tag for creating printable error
 * @author tonyj
 */
public class ReportError extends SimpleTagSupport
{
   private Throwable error;
   private boolean brief;
   
   public void doTag() throws JspException, IOException
   {
      JspWriter writer = getJspContext().getOut();
      writer.print("<pre>");
      if (error instanceof JspException && (( JspException) error).getRootCause() != null) error = ((JspException) error).getRootCause();
      error.printStackTrace(new PrintWriter(new BriefWriter(writer,brief)));
      writer.print("</pre>");
   }
   
   public void setError(Throwable error)
   {
      this.error = error;
   }
   public void setBrief(boolean brief)
   {
      this.brief = brief;
   }
}