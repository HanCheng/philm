package app.philm.in.test;

import app.philm.in.network.BackgroundCallRunnable;
import app.philm.in.network.TraktNetworkCallRunnable;
import app.philm.in.util.BackgroundExecutor;

public class FakeBackgroundExecutor implements BackgroundExecutor {

    @Override
    public <R> void execute(TraktNetworkCallRunnable<R> runnable) {
        runnable.onPreTraktCall();
        runnable.onSuccess(runnable.doBackgroundCall());
        runnable.onFinished();
    }

    @Override
    public <R> void execute(BackgroundCallRunnable<R> runnable) {
        runnable.preExecute();
        runnable.postExecute(runnable.runAsync());
    }
}