package richard.demo.API;

import org.springframework.web.bind.annotation.*;
import richard.demo.models.APIcall;

@CrossOrigin(origins = "http://localhost:5176")
@RestController
@RequestMapping("/api")
public class Controller {

    APIcall apiCall = new APIcall();

    @GetMapping("/{tipo}/brands")
    public String getBrands(@PathVariable String tipo){
        return apiCall.MostrarMarcas(tipo);
    }

    @GetMapping("/{tipo}/brands/{codigoMarca}/models")
    public String getModels(@PathVariable String tipo, @PathVariable String codigoMarca){
        return apiCall.MostrarModelos(tipo, codigoMarca);
    }

    @GetMapping("/{tipo}/brands/{codigoMarca}/models/{codigoModelo}/years")
    public String getYears(@PathVariable String tipo, @PathVariable String codigoMarca, @PathVariable String codigoModelo){
        return apiCall.MostrarAnos(tipo, codigoMarca, codigoModelo);
    }

    @GetMapping("/{tipo}/brands/{codigoMarca}/models/{codigoModelo}/years/{codigoAno}")
    public String getFinalModel(@PathVariable String tipo, @PathVariable String codigoMarca, @PathVariable String codigoModelo, @PathVariable String codigoAno){
        return apiCall.MostrarValor(tipo, codigoMarca, codigoModelo, codigoAno);
    }

}
