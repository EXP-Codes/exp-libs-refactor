/**
 * 修正 commons-httpclient-3.1 自动重定向丢失 Response Header 中的 Set-Cookie 的 BUG:
 *  当使用 HttpClient 访问一个会发生重定向跳转的 URL 时,
 *  会自动执行跳转, 直到跳转到最后一个目标URL为止, 而这个自动的重定向行为无法被禁止.
 *
 * 由于这个行为, 会发生两个现象：
 *  1.使用 HttpClient 访问原始 URL 后，直接返回的状态码就是 200 （而非 302 ）.
 *  2.得到的 Response Header 是最后一个 URL 的 Response Header，而中间跳转的 URL 的 Response Header 全部丢失.
 *
 * 第 1 点其实影响不大, 但第 2 点会导致中间跳转的URL所返回的 Set-Cookie 丢失,
 * 因此此处主要针对第 2 点进行改写：
 *  记录中间所有 URL 返回的 Response Header 中的 Set-Cookie，并全部追加到最后一个 URL 的 Response Header 中.
 */
package org.apache.commons.httpclient;