package iegcode.wevmvc.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController implements ErrorController {

    @RequestMapping(path = "/error")
    public ResponseEntity<String> error(HttpServletRequest request){
        Integer status = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String message = (String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE);

        String html = """
                <html>
                 <head>
                    <meta charset="UTF-8" />
                    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                    <title>Oops! Maintenance</title>
                    <style>
                      body {
                        background-color: black;
                        display: flex;
                        align-items: center;
                        justify-content: center;
                        height: 100vh;
                        margin: 0;
                        font-family: Helvetica, sans-serif;
                        color: #fff;
                      }
                                
                      article {
                        text-align: left;
                        max-width: 650px;
                        padding: 20px;
                      }
                                
                      h1 {
                        font-size: 36px;
                      }
                                
                      p {
                        font-size: 18px;
                        line-height: 1.6;
                      }
                                
                      a {
                        color: rgb(4, 122, 254);
                        text-decoration: none;
                      }
                                
                      a:hover {
                        color: #333;
                        text-decoration: underline;
                      }
                                
                      @media screen and (max-width: 600px) {
                        article {
                          max-width: 100%;
                        }
                      }
                    </style>
                  </head>
                <body>
                    <article>
                      <h1>We&rsquo;ll be back soon!</h1>
                      <div>
                        <p>
                          Sorry for the inconvenience, but we&rsquo;re performing some
                          maintenance at the moment. If you need to, you can always
                          <a
                            href="https://mail.google.com/mail/u/0/?fs=1&to=ibrahimelgibran17@gmail.com&su=Your%20Subject&body=Your%20Messages&tf=cm"
                            >contact us</a
                          >. Otherwise, we&rsquo;ll be back online shortly!
                        </p>
                        <p>&mdash; IegcodeTube.</p>
                      </div>
                    </article>
                  </body>
                </html>
                """.replace("$status", status.toString()).replace("$message", message);

        return ResponseEntity.status(status).body(html);
    }
}

//@Controller
//public class ErrorPageController implements ErrorController {
//
//    @RequestMapping(path = "/error")
//    public ResponseEntity<String> error(HttpServletRequest request) {
//        Integer status = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//        String message = (String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
//
//        String html = """
//                <html>
//                <body>
//                <h1>$status - $message</h1>
//                </body>
//                </html>
//                """.replace("$status", status.toString()).replace("$message", message);
//
//        return ResponseEntity.status(status).body(html);
//    }
//}