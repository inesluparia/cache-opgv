package cacheopgv.Controller;

import cacheopgv.User;
import cacheopgv.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/get-user-data")
    @ResponseBody
    public String getUserData(@RequestParam int id) throws InterruptedException {
        User user = new User(id);
        UserData data = user.getUserData();
        user.setTTL(id);
        return data.getData();
    }

}
