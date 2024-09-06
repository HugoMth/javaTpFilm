package eni.tp.app.eni_app.utils;

public class EniFlashMessage {

    //Pour rappel :
    //static = utilisable partout; final = contante
    public static final int TYPE_FLASH_SUCCESS = 0;
    public static final int TYPE_FLASH_ERROR = 1;

    public int type;
    public String message;

    public EniFlashMessage(int type, String message) {
        this.type = type;
        this.message = message;
    }

    /**
     * Fonction pour le front
     * permet de selectionner quelle classe CSS utiliser
     * selon le type du message (succes ? error ? etc.)
     *
     * @return
     */
    public String getTypeCssClass() {
        if (type == TYPE_FLASH_SUCCESS) {
            return "bg-green-500";
        }
        if (type == TYPE_FLASH_ERROR) {
            return "bg-red-500";
        }
        return "bg-blue-500";
    }

}