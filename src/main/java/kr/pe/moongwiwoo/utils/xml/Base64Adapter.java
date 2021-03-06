package kr.pe.moongwiwoo.utils.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Base64Adapter extends XmlAdapter<byte[], String> {

	@Override
	public String unmarshal(byte[] v) throws Exception {
		return new String(v);
	}

	@Override
	public byte[] marshal(String v) throws Exception {
		return v.getBytes();
	}

}
