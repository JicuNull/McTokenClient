package org.jannsen.mctoken.client;

import org.jannsen.mcreverse.api.entity.akamai.SensorToken;
import org.jannsen.mctoken.client.McToken;
import org.jannsen.mctoken.client.response.Response;
import org.jannsen.mctoken.client.response.TokenResponse;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class McTokenTest {

    private final McToken mcToken = new McToken("http://localhost:8083");
    private final String t = "1,a,CZbd+alabakPoewH7626MQqe7Eq4kfP99tkBIah52VDLoHGTtL8CxBmWRHUtSR7p4JGJPuDnmDPIbUwBahmmlzbom2rdGG8cgJUfldERtsiQO/u3Ek/75B0v09S7gUWnmol7VFQlOpW/8sR6S5xEQlIYrdilP4poQ8+hK5+VbhM=,aFp8pCwbjG2F/GnaIC9241q0HcXOkiUJ7GhZS+VgMv/GZCu6ZidaNy9V/XveL1JLRpO8WG9xrGufIapK1Zy5OC8c3HI0msHrRu1JiO0aosH24rDyr2x3Nl92SN2SIBqxkYBPZy8YjVyeInwkQviYF1/gkoIBa3hg5d18n+0morA=$qJc+htLOi0xOHD0Zts5muEo+Feteo0pxq8qoge99komei0SrTSk4U7h0w3HCPcsHsVXuFzLwyL/B8sI4XH3bS3LQ9gWyzyasgNe/kN30MBRcUwiCiQIMjKyaekY7e4mxU96t6VuJqpExuWnLm/oWwcxRAPmLSKu8MgyORrrTEi9148T4veEggIGlKKzKvzmICZvDJeLutyAK+GuTQRCs9rxlmtCeomqppi/hTv17a5Tmj6BH09nKsB7AKOigHpnJH2vxap0Qf/Bx052NJUtabHlExfKzyQnGPRXDBsPY+tkVhmWiuoMVfBUxpDerxsPih8Ocbcj2o1H7TgttG4pTDI/Mv/UmQdwfN4EZnQU6SCiwFYihdxcnqhVce7l7U/oeA47Hs1Vw6YSkbIcyLCQGqy19OuVSumLSZmhmDixqbCd7kHP7XvA2ThhuNaCmGSpF6Dwd3Ccdrzjs9s5TM1ru7hryK+M3OVKkVAaKGX3VnHOxbwO1/VX0msGwlt7bRVok+nPJcouDn/QEHk0ma7GpQwWxIlJjucMo4+D8XXUZuJBIqcHQjRCklZYEVLdPGODlns5Vs3ppXsK5T7K4kNP0kJmtvqcRWsI0LVRiJ4UrH5p5n29eenKwEUWI/F9ZRAkGeffkFUWYqNJ8mCPXeiZcxpjMTJ9TlQLFQSd32pld5sinWLnlWBCfAEVB1FDw2LBNWd9yHFVQd5Es6fB5x/Afqe0Lhpk5y3sjClKS4h9t6jLzD+LBHNR9XxWkm4Dz21AlTnmgJxjGKanbWKHG74tzZy4ZIwLUKMtdDhr/kWQDTcXjPGXaOvOSpXBQk/GgFq/8ZUVTku3QLrXjEU3IRPx4cNKbij7LedISG0RXM098d8hW/Gyur8Vu5yrAUPmjnBMhMg560xhUpDnDZ6CcMqH34xX0is3eMfGNcyGPnr1vb+iXv+yeKxs4z4/o0PujjYhaJuTlU6DZljnsw/VSYMG6g8aD2UoOSSIUkiJgP3A4zMi+DId3jKsDjUfltguXfA3nmUUf8mLyH0TmAFkjsRvQe9zoHmEq18+WyymU9cq/xeo=$0,0,0";

    @Test
    public void saveToken() {
        SensorToken token = new SensorToken(t, Instant.now().getEpochSecond());
        Response response = mcToken.saveToken(token);
        assertTrue(response.success());
    }

    @Test
    public void getToken() {
        TokenResponse response = mcToken.getToken();
        System.out.println(response.getResponse().getToken());
        assertTrue(response.success());
    }
}
