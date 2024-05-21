package br.com.petspot.model.messages.login;

import lombok.Data;


@Data
public class MessageToRequestNewPassword{
        private String message;

        public MessageToRequestNewPassword(String message){
            this.message = message;
        }
}
