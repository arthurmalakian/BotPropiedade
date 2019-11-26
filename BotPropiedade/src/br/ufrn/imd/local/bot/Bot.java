package br.ufrn.imd.local.bot;

import br.ufrn.imd.local.data.Archivesys;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;
import java.io.File;
import java.util.List;
import java.util.Map;

public class Bot {
    
    private TelegramBot bot;
    Archivesys armazenamento;
    
    private GetUpdatesResponse updatesResponse;
    private SendResponse sendResponse;
    private BaseResponse baseResponse;
		
    
    public Bot(String token) {
        bot = TelegramBotAdapter.build(token);
    }
    
    public void setup(){
        //armazenamento.setup();    
    }
    public void run(){
        
        int m = 0;
        while (true){
            updatesResponse =  bot.execute(new GetUpdates().limit(100).offset(m));	
            List<Update> updates = updatesResponse.updates();
            for (Update update : updates) {
                m = update.updateId()+1;
                switch(update.message().text().toLowerCase()) {
                    case "/ajuda":
                        Falar("Comandos disponiveis:"
                                + "\n/cadastrarlocalização"
                                + "\n/cadastrarcategoria"
                                + "\n/cadastrarbem"
                                + "\n/listarlocalizações"
                                + "\n/listarcategorias"
                                + "\n/listarbenslocalização"
                                + "\n/buscaporcodigo"
                                + "\n/buscapornome"
                                + "\n/buscapordescrição",update);
                        break;
                    case "/cadastrarlocalização":
                        Falar("Digite o nome da sua localização",update);
                        break;
                    case "/cadastrarcategoria":
                        Falar("Digite o nome da sua categoria",update);
                        break;
                    case "/cadastrarbem":
                        Falar("Digite o nome do seu bem",update);
                        break;
                    case "/listarlocalizações":
                        Falar("Localizações cadastradas: ",update);
                        break;
                    case "/listarcategorias":
                        Falar("Categorias cadastradas: ",update);
                        break;
                    case "/listarbenslocalização":
                        Falar("Digite o nome da localização",update);
                        break;
                    case "/buscaporcodigo":
                        Falar("Digite o código do bem",update);
                        break;
                    case "/buscapornome":
                        Falar("Digite o nome do bem",update);
                        break;
                    case "/buscapordescrição":
                        Falar("Digite a descrição do bem",update);
                        break;
                }
				
            }

	}
    }
    /*  
    public void criarItem(String nome, String descricao,Update u){
        Item tmp = new Item(nome,descricao);
        if(!armazenamento.createItemData(tmp)) {
            Falar("Não foi possível cadastrar item, pois já se encontra cadastrado.",u);
            return;
        }
        
    }
    */
    public void criarItem(String nome,String descricao, Local local,Categoria categoria) {
        
    }
    public void modificarItem(Item item, String novo_nome, String nova_descricao) {
    
    }
    public void excluirItem(Item item) {
    
    }
    public void Falar(String conteudo,Update update) {
        baseResponse = bot.execute(new SendChatAction(update.message().chat().id(), ChatAction.typing.name()));
        sendResponse = bot.execute(new SendMessage(update.message().chat().id(),conteudo));
    }
}
