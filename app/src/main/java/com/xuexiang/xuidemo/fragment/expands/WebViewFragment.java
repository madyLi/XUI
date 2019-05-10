/*
 * Copyright (C) 2019 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xuexiang.xuidemo.fragment.expands;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xui.widget.actionbar.TitleBar;
import com.xuexiang.xuidemo.R;
import com.xuexiang.xuidemo.base.BaseSimpleListFragment;
import com.xuexiang.xuidemo.utils.Utils;

import java.util.List;

/**
 * @author xuexiang
 * @since 2019/1/5 上午12:39
 */
@Page(name = "web浏览器", extra = R.drawable.ic_expand_web)
public class WebViewFragment extends BaseSimpleListFragment {
    @Override
    protected List<String> initSimpleData(List<String> lists) {
        lists.add("使用系统默认API调用");
        lists.add("直接显示调用");
        lists.add("文件下载");
        lists.add("input标签文件上传");
        lists.add("电话、信息、邮件");
        lists.add("地图定位");
        return lists;
    }

    @Override
    protected void onItemClick(int position) {
        switch (position) {
            case 0:
                systemApi("https://www.baidu.com/");
                break;
            case 1:
                Utils.goWeb(getContext(), "https://www.baidu.com/");
                break;
            case 2:
                Utils.goWeb(getContext(), "http://android.myapp.com/");
                break;
            case 3:
                Utils.goWeb(getContext(), "file:///android_asset/upload_file/uploadfile.html");
                break;
            case 4:
                Utils.goWeb(getContext(), "file:///android_asset/sms/sms.html");
                break;
            case 5:
                Utils.goWeb(getContext(), "https://map.baidu.com/mobile/webapp/index/index/#index/index/foo=bar/vt=map");
                break;
            default:
                break;
        }
    }

    /**
     * 以系统API的方式请求浏览器
     *
     * @param url
     */
    public void systemApi(final String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    @Override
    protected TitleBar initTitle() {
        TitleBar titleBar = super.initTitle();
        titleBar.addAction(new TitleBar.TextAction("Github") {
            @Override
            public void performAction(View view) {
                Utils.goWeb(getContext(), "https://github.com/Justson/AgentWeb");
            }
        });
        return titleBar;
    }


}
