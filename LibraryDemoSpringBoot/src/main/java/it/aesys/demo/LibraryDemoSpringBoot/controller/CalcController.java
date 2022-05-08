package it.aesys.demo.LibraryDemoSpringBoot.controller;

import it.aesys.demo.LibraryDemoSpringBoot.models.PriceModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {

  @RequestMapping(method = RequestMethod.GET, value = "/calc")
  public ModelAndView calc(
      @RequestParam(value = "price", required = true) Double price,
      @RequestParam(value = "discount", required = true) Double discount
  ) {
    double finalPrice = price - (price * discount);

    ModelAndView response = new ModelAndView();
    response.setViewName("calc");
    response.addObject("calcResult", finalPrice);

    return response;
  }

  @RequestMapping(method = RequestMethod.POST, value = "/calc/{price}/{pippo}/applyDiscount")
  @ResponseBody
  public PriceModel calcOnlyResponse(
      @PathVariable(value = "price") Double price,
      @PathVariable(value = "pippo") String pippo,
      @RequestParam(value = "discount", required = false) Double discount
  ) {

    PriceModel response = new PriceModel();
    response.setPippo(pippo);
    response.setPrice(price);
    response.setDisccount(discount == null ? 0 : discount);

    if (discount != null && discount != 0)
      response.setFinalPrice(price - (price * discount));
    else
      response.setFinalPrice(price);

    return response;
  }

}
