package eni.tp.app.eni_app.utils;

import eni.tp.app.eni_app.utils.EniFlashMessage;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class Utils {

    public static void sendCommonFlashMessage(RedirectAttributes redirectAttributes, int type, String message) {
        redirectAttributes.addFlashAttribute("flashMessage",
                new EniFlashMessage(type, message));
    }

    public static void sendSuccessFlashMessage(RedirectAttributes redirectAttributes, String message) {
        redirectAttributes.addFlashAttribute("flashMessage",
                new EniFlashMessage(EniFlashMessage.TYPE_FLASH_SUCCESS, message));
    }
}
