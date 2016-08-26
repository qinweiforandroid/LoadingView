# LoadingView
提供首次进入页面加载状态解决方案

# 效果图
![image](http://img.blog.csdn.net/20160329110427080)

# how to use
你可以将你的主布局设置成帧布局或者相对布局 使得loadingview 覆盖到内容页面之上
xml 配置:
<com.qw.loadingview.widget.LoadingView
        android:id="@id/mLoadingView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

Activity:
LoadingView mLoadingView = (LoadingView) findViewById(R.id.mLoadingView);
//notifyDataChanged()切换各个view之前的状态
mLoadingView.notifyDataChanged(LoadingView.State.ing);

LoadingView.State加载状态
public enum State {
        ing, error, done, empty
}
# 样式
样式你可以根据你自己的业务进行定制
