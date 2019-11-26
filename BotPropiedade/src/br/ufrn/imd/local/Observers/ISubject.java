package br.ufrn.imd.local.Observers;

import br.ufrn.imd.local.Observers.IObserver;
import br.ufrn.imd.local.bot.Item;

public interface ISubject {
    public void register(IObserver o);
    public void unregister(IObserver o);
    public void notificar(Item self);  
}
