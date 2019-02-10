package pl.gregrad.myhome.controllers.BillControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gregrad.myhome.dto.BillsDTO;
import pl.gregrad.myhome.entity.Bills;
import pl.gregrad.myhome.services.AddBillService;

@Controller
@RequestMapping("/add_Bill")
public class AddBillController {

    @Autowired
    private AddBillService addBillService;

    @GetMapping
    public String showBillForm(Model model) {
        model.addAttribute("bill", new BillsDTO());
        return "Add_Bill";
    }
    @PostMapping
    public String addBill (@ModelAttribute BillsDTO bill )  {
        addBillService.addBill(bill);
        return "redirect:/all_Bills";
    }
}
