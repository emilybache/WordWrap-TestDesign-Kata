import {WordWrapBlausten} from "./WordWrapBlausten";
import {WordWrapBlausten2} from "./WordWrapBlausten2";
import {WordWrapKoflerLoop} from "./WordWrapKoflerLoop";
import {WordWrapKoflerRegex} from "./WordWrapKoflerRegex";
import {WordWrapMartin} from "./WordWrapMartin";
import WordWrap from "./WordWrap";

describe.each([
    ["WordWrapBlausten", new WordWrapBlausten()],
    ["WordWrapBlausten2", new WordWrapBlausten2()],
    ["WordWrapKoflerLoop", new WordWrapKoflerLoop()],
    ["WordWrapKoflerRegex", new WordWrapKoflerRegex()],
    ["WordWrapMartin", new WordWrapMartin()]
])("WordWrap implemented with %s", (name, wrapper: WordWrap) => {

    // TODO: write some more test cases like this one
    it('wraps an empty string ', () => {
        expect(wrapper.wrap("", 1)).toBe("");
    });
})