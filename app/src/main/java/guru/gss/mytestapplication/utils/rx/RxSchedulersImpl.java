package guru.gss.mytestapplication.utils.rx;

import io.reactivex.MaybeTransformer;
import io.reactivex.Scheduler;
import io.reactivex.SingleTransformer;

public abstract class RxSchedulersImpl {

    abstract public Scheduler getMainThreadScheduler();

    abstract public Scheduler getIOScheduler();

    abstract public Scheduler getComputationScheduler();

    public <T> SingleTransformer<T, T> getIOToMainTransformer() {
        return objectObservable -> objectObservable
                .subscribeOn(getIOScheduler())
                .observeOn(getMainThreadScheduler());
    }

    public <T> MaybeTransformer<T, T> getMaybeIOToMainTransformer() {
        return objectObservable -> objectObservable
                .subscribeOn(getIOScheduler())
                .observeOn(getMainThreadScheduler());
    }

    public <T> SingleTransformer<T, T> getComputationToMainTransformer() {
        return objectObservable -> objectObservable
                .subscribeOn(getComputationScheduler())
                .observeOn(getMainThreadScheduler());
    }

}
