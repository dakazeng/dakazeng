package com.ldq.emu;

import java.util.ArrayList;
import java.util.List;

public class SecurityUrl {
	private List<String> skipUrl = new ArrayList<>();

	public List<String> getSkipUrl() {
		return skipUrl;
	}

	public void setSkipUrl(List<String> skipUrl) {
		this.skipUrl = skipUrl;
	}
}
