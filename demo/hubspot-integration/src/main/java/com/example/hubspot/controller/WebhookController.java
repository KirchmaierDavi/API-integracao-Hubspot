import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

    private final WebhookService webhookService;

    public WebhookController(WebhookService webhookService) {
        this.webhookService = webhookService;
    }

    @PostMapping("/webhook/contact.creation")
    public ResponseEntity<Void> handleContactCreation(@RequestBody String payload) {
        webhookService.processContactCreation(payload);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}