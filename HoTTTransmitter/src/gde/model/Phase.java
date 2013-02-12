package gde.model;

import java.util.Map;

public class Phase {
	private Map<Function, DualRateExpo> dualRate;
	private PhasedMixer mixer;
	private String name;
	private PhasedTrim trim;
	private PhaseType type;

	public Map<Function, DualRateExpo> getDualRate() {
		return dualRate;
	}

	public PhasedMixer getMixer() {
		return mixer;
	}

	public String getName() {
		return name;
	}

	public PhasedTrim getTrim() {
		return trim;
	}

	public PhaseType getType() {
		return type;
	}

	public void setDualRate(final Map<Function, DualRateExpo> dualRate) {
		this.dualRate = dualRate;
	}

	public void setMixer(final PhasedMixer mixer) {
		this.mixer = mixer;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setTrim(final PhasedTrim trim) {
		this.trim = trim;
	}

	public void setType(final PhaseType type) {
		this.type = type;
	}
}
