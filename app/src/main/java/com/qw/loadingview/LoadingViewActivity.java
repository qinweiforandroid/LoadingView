package com.qw.loadingview;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ViewSwitcher;

import com.qw.loadingview.widget.LoadingView;


public class LoadingViewActivity extends AppCompatActivity implements LoadingView.OnRetryListener {

    private ViewSwitcher mViewSwitcher;
    private LoadingView mLoadingView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_view);
        mLoadingView = (LoadingView) findViewById(R.id.mLoadingView);
        mLoadingView.setOnRetryListener(this);
        mLoadingView.notifyDataChanged(LoadingView.State.ing);
        mViewSwitcher = (ViewSwitcher) findViewById(R.id.mViewSwitcher);
        mViewSwitcher.setDisplayedChild(0);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_loading_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_one:
                mViewSwitcher.setDisplayedChild(0);
                break;
            case R.id.action_two:
                mViewSwitcher.setDisplayedChild(1);
                mLoadingView.notifyDataChanged(LoadingView.State.ing);
                break;
            case R.id.action_nodata:
                mLoadingView.notifyDataChanged(LoadingView.State.empty);
                break;
            case R.id.action_loading:
                mLoadingView.notifyDataChanged(LoadingView.State.ing);
                break;
            case R.id.action_err:
                mLoadingView.notifyDataChanged(LoadingView.State.error);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRetry() {
        mLoadingView.notifyDataChanged(LoadingView.State.ing);
    }
}
