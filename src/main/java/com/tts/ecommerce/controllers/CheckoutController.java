package com.tts.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tts.ecommerce.model.ChargeRequest;

@Controller
public class CheckoutController {

    @Value("pk_test_51IRjXBBE6kcte9QQ1nHL42irILRunHsi779TCDdJX3bDSSqN23RJAhbeprv40EeMqbUym1floQSXKvROhnMEmH8P00IhKmQ1yw")
    private String stripePublicKey;

    @RequestMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("amount", 50 * 100); // in cents
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.EUR);
        return "checkout";
    }
}