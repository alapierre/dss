/**
 * DSS - Digital Signature Services
 * Copyright (C) 2015 European Commission, provided under the CEF programme
 * 
 * This file is part of the "DSS - Digital Signature Services" project.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package eu.europa.esig.dss.validation.policy;

import eu.europa.esig.dss.validation.SignaturePolicy;

/**
 * This class covers the case of empty signature policies (no asn1,... file has been downloaded)
 */
public class EmptySignaturePolicyValidator extends AbstractSignaturePolicyValidator {

	/**
	 * Default constructor
	 */
	public EmptySignaturePolicyValidator() {
		// empty
	}

	@Override
	public boolean canValidate(SignaturePolicy signaturePolicy) {
		return signaturePolicy.getPolicyContent() == null && !signaturePolicy.isZeroHash();
	}

	@Override
	public SignaturePolicyValidationResult validate(SignaturePolicy signaturePolicy) {
		SignaturePolicyValidationResult validationResult = new SignaturePolicyValidationResult();
		validationResult.setDigestValid(signaturePolicy.getIdentifier().isEmpty());
		return validationResult;
	}

}
