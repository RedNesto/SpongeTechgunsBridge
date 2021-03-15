package io.github.rednesto.spongetechguns.mixin;

import org.spongepowered.api.entity.projectile.Projectile;
import org.spongepowered.api.entity.projectile.source.ProjectileSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.entity.EntityLivingBase;
import techguns.entities.projectiles.GenericProjectile;

@Mixin(GenericProjectile.class)
public abstract class GenericProjectileMixin implements Projectile {
	
	@Shadow protected EntityLivingBase shooter;
	
	@Override
	public ProjectileSource getShooter() {
		return (ProjectileSource) this.shooter;
	}
	
	@Override
	public void setShooter(ProjectileSource shooter) {
		if (shooter instanceof EntityLivingBase) {
			this.shooter = (EntityLivingBase) shooter;
		}
	}
}
